package greedzCorp.pocketGym.business.constants;

public class GeneralEnums {

    public enum ProductOrderTypes{
        ACTIVE("ACTV"),
        PASSIVE("PASSIVE"),
        CANCELLED("CANCELLED"),
        OPEN("OPEN"),
        DELETED("DELETED"),
        CART("CART"),
        PENDING("PENDING"),
        DENIDE("DENIED"),
        ACCEPTED("ACCEPTED"),
        CLOSED("CLOSED");



        private String shrtCode;

        ProductOrderTypes(String shrtCode) {
            this.shrtCode = shrtCode;
        }
        public String getShrtCode() {
            return shrtCode;
        }
    }
    private enum PartyTypes{
        INDIVIDUAL("IND"),
        BUSINESS("BSN"),
        TRAINER("PT");


        private String shrtCode;

        PartyTypes(String shrtCode) {
            this.shrtCode = shrtCode;
        }
        public String getShrtCode() {
            return shrtCode;
        }
    }

}
