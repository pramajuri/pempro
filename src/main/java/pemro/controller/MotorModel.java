package pemro.controller;

public class MotorModel {

    private int id_motor;
    private String merk;
    private String jenis;
    private String nopol;
    private int harga;

    public MotorModel(int Id_motor, String Merk, String Jenis, String Nopol, int Harga) {
        this.id_motor = Id_motor;
        this.merk = Merk;
        this.jenis = Jenis;
        this.nopol = Nopol;
        this.harga = Harga;
    }

    public int getId_motor() {
        return id_motor;
    }

    public void setId_motor(int id_motor) {
        this.id_motor = id_motor;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNopol() {
        return nopol;
    }

    public void setNopol(String nopol) {
        this.nopol = nopol;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public String toString() {
        return merk;
    }
}
