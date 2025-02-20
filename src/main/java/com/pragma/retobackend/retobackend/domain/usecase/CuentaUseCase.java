package com.pragma.retobackend.retobackend.domain.usecase;

import com.pragma.retobackend.retobackend.domain.api.ICuentaServicePort;
import com.pragma.retobackend.retobackend.domain.enums.RolCuentaEnum;
import com.pragma.retobackend.retobackend.domain.exception.DomainException;
import com.pragma.retobackend.retobackend.domain.model.CuentaObject;
import com.pragma.retobackend.retobackend.domain.spi.ICuentaPersistencePort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.regex.Pattern;

public class CuentaUseCase implements ICuentaServicePort {

    private final ICuentaPersistencePort cuentaPersistencePort;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    private static final String PHONE_REGEX = "^\\+?[0-9]{1,13}$";
    private static final Pattern PHONE_PATTERN = Pattern.compile(PHONE_REGEX);


    public CuentaUseCase(ICuentaPersistencePort cuentaPersistencePort) {
        this.cuentaPersistencePort = cuentaPersistencePort;
    }

    @Override
    public void save(CuentaObject cuentaObject) {
        validarEmail(cuentaObject.getCorreo());
        validarTelefono(cuentaObject.getTelefono());
        esMayorDeEdad(cuentaObject.getFechaDeNacimiento());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        cuentaObject.setClave(passwordEncoder.encode(cuentaObject.getClave()));
        cuentaObject.setRol(RolCuentaEnum.PROPIETARIO);

        cuentaPersistencePort.save(cuentaObject);
    }

    @Override
    public List<CuentaObject> getAll() {
        return cuentaPersistencePort.getAll();
    }

    @Override
    public CuentaObject getCuentaByCorreoAndPassword(String correo,String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        CuentaObject cuenta = cuentaPersistencePort.getCuentaByEmail(correo);

        if(cuenta == null){
            throw new DomainException("Cuenta no existe.");
        }

        if(!passwordEncoder.matches(password,cuenta.getClave())){
            throw new DomainException("Contraseña incorrecta.");
        }

        return cuenta;
    }

    @Override
    public CuentaObject getById(Long id) {
        return cuentaPersistencePort.getById(id);
    }

    @Override
    public void createEmployeed(CuentaObject cuentaObject, String usuario) {
        validarEmail(cuentaObject.getCorreo());
        validarTelefono(cuentaObject.getTelefono());
        esMayorDeEdad(cuentaObject.getFechaDeNacimiento());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        cuentaObject.setClave(passwordEncoder.encode(cuentaObject.getClave()));
        cuentaObject.setRol(RolCuentaEnum.EMPLEADO);

        CuentaObject cuenta = cuentaPersistencePort.getCuentaByEmail(usuario);
        cuentaObject.setRestaurante(cuenta.getRestaurante());

        cuentaPersistencePort.save(cuentaObject);
    }

    @Override
    public void createClient(CuentaObject cuentaObject) {
        validarEmail(cuentaObject.getCorreo());
        validarTelefono(cuentaObject.getTelefono());
        esMayorDeEdad(cuentaObject.getFechaDeNacimiento());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        cuentaObject.setClave(passwordEncoder.encode(cuentaObject.getClave()));
        cuentaObject.setRol(RolCuentaEnum.CLIENTE);

        cuentaPersistencePort.save(cuentaObject);
    }

    @Override
    public CuentaObject getCuentaByEmail(String email) {
        return cuentaPersistencePort.getCuentaByEmail(email);
    }

    private void validarEmail(String email) {
        if (email == null || !EMAIL_PATTERN.matcher(email).matches()) {
            throw new DomainException("Email invalido");
        }
    }

    public void validarTelefono(String telefono) {
        if (telefono == null || !PHONE_PATTERN.matcher(telefono).matches()) {
            throw new IllegalArgumentException("El teléfono '" + telefono + "' no es válido. Debe contener máximo 13 caracteres y solo puede incluir números y el símbolo '+'.");
        }
    }

    public void esMayorDeEdad(LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) {
            throw new DomainException("La fecha de nacimiento no puede ser nula.");
        }

        LocalDate hoy = LocalDate.now();
        if(Period.between(fechaNacimiento, hoy).getYears() < 18){
            throw new DomainException("No puede ser menor de edad.");
        }
    }
}
