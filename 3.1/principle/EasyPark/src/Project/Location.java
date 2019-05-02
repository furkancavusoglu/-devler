package Project;

public enum Location {
    TEPEBAŞI,SİVRİHİSAR,SEYİTGAZİ,SARICAKAYA,ODUNPAZARI,MİHALIÇÇIK,MİHALGAZİ,MAHMUDİYE,İNÖNÜ,HAN,GÜNYÜZÜ,ÇİFTELER,BEYLİKOVA,ALPU;
    @Override
    public  String toString(){
            switch (this){
                case TEPEBAŞI:  return "Tepebaşı";
                case SİVRİHİSAR:return "Sivrihisar";
                case SEYİTGAZİ: return "Seyitgazi";
                case SARICAKAYA:return "Sarıcakaya";
                case ODUNPAZARI:return "Odunpazarı";
                case MİHALIÇÇIK:return "Mihalıççık";
                case MİHALGAZİ: return "Mihalgazi";
                case MAHMUDİYE: return "Mahmudiye";
                case İNÖNÜ:     return "İnönü";
                case HAN:       return  "Han";
                case GÜNYÜZÜ:   return "Günyüzü";
                case ÇİFTELER:  return "Çifteler";
                case BEYLİKOVA: return "Beylikova";
                case ALPU:      return "Alpu";
                default:        return "Eskişehir";
            }
    }
}
