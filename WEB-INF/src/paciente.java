public class paciente {

    private String motivoIng, nombreMas, sexo, especie;
    int id;

    public paciente(String motivoIng, String nombreMas, String sexo, String especie) {
        this.motivoIng = motivoIng;
        this.nombreMas = nombreMas;
        this.sexo = sexo;
        this.especie = especie;
    }

    public String getMotivoIng() {
        return motivoIng;
    }

    public void setMotivoIng(String motivoIng) {
        this.motivoIng = motivoIng;
    }

    public String getNombreMas() {
        return nombreMas;
    }

    public void setNombreMas(String nombreMas) {
        this.nombreMas = nombreMas;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "paciente [especie=" + especie + ", id=" + id + ", motivoIng=" + motivoIng + ", nombreMas=" + nombreMas
                + ", sexo=" + sexo + "]";
    }

    public paciente(int id, String motivoIng, String nombreMas, String sexo, String especie) {
        this.motivoIng = motivoIng;
        this.nombreMas = nombreMas;
        this.sexo = sexo;
        this.especie = especie;
        this.id = id;
    }

}