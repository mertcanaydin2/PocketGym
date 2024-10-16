package greedzCorp.pocketGym.business.constants;

public class GeneralEnums {

    public enum DateFormats{

        ddMMyyyy("dd/MM/yyyy","dd/MM/yyyy"),
        ddMMMMyyyy("dd MMMM yyyy","dd MMMM yyyy"),
        ddMMMMyyyyHHmm("dd MMMM yyyy HH:mm","dd MMMM yyyy HH:mm");

        //TODO BURAYI DÜZENLE.


        private String formatName;
        private String format;

        DateFormats(String formatName, String format) {
            this.formatName = formatName;
            this.format = format;
        }

        public String getFormatName() {
            return formatName;
        }

        public String getFormat() {
            return format;
        }
    }
}
