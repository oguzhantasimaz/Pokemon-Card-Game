package sample;

import java.util.ArrayList;

public class Oyuncu {

    private int Skor;
    ArrayList<String> kartListesi = new ArrayList<>();

    public ArrayList<String> getKartListesi() { return kartListesi; }
    public void setKartListesi(ArrayList<String> kartListesi) { this.kartListesi = kartListesi; }
    public int getSkor() { return Skor; }
    public void setSkor(int skor) { Skor = skor; }

    public class InsanOyuncusu extends Oyuncu
    {
        //KART LISTESI
        private int oyuncuID;
        private String oyuncuAdi;

        public int getOyuncuID() { return oyuncuID; }
        public void setOyuncuID(int oyuncuID) { this.oyuncuID = oyuncuID; }
        public String getOyuncuAdi() { return oyuncuAdi; }
        public void setOyuncuAdi(String oyuncuAdi) { this.oyuncuAdi = oyuncuAdi; }

        @Override
        public ArrayList<String> getKartListesi() {
            return super.getKartListesi();
        }
        @Override
        public void setKartListesi(ArrayList<String> kartListesi) {
            super.setKartListesi(kartListesi);
        }
        @Override
        public int getSkor() {
            return super.getSkor();
        }
        @Override
        public void setSkor(int skor) {
            super.setSkor(skor);
        }
    }
    public class BilgisayarOyuncusu extends Oyuncu
    {
        @Override
        public ArrayList<String> getKartListesi() {
            return super.getKartListesi();
        }
        @Override
        public void setKartListesi(ArrayList<String> kartListesi) {
            super.setKartListesi(kartListesi);
        }
        @Override
        public int getSkor() {
            return super.getSkor();
        }
        @Override
        public void setSkor(int skor) {
            super.setSkor(skor);
        }
    }

}
