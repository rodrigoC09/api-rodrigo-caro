package foro.hub.api.rodrigo.caro.infra.errores;

public class ValidacionDeIntegridad extends RuntimeException {
    public ValidacionDeIntegridad(String s) {
        super(s);
    }
}
