package wordmemory.idalavye.com.expandablelist;

public class Contacto {
    private String numero,correo,direction;
    private int img;

    public Contacto(String numero, String correo, String direction, int img) {
        this.numero = numero;
        this.correo = correo;
        this.direction = direction;
        this.img = img;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
