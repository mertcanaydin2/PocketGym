package greedzCorp.pocketGym.business.constants;

public class StateEnums {

    public enum BuddyStates {

        ACTV("ACTV", 1201L),
        PASSIVE("PASSIVE", 1202L),
        MATCHED("MATCHED", 1203L);

        private String shrtCode;
        private Long stId;

        BuddyStates(String shrtCode, Long stId) {
            this.shrtCode = shrtCode;
            this.stId = stId;
        }

        public String getShrtCode() {
            return shrtCode;
        }

        public Long getStId() {
            return stId;
        }
    }

    public enum ProductOrderStates{
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

        ProductOrderStates(String shrtCode) {
            this.shrtCode = shrtCode;
        }
        public String getShrtCode() {
            return shrtCode;
        }
    }

    private enum PartyStates{
        INDIVIDUAL("IND"),
        BUSINESS("BSN"),
        TRAINER("PT");


        private String shrtCode;

        PartyStates(String shrtCode) {
            this.shrtCode = shrtCode;
        }
        public String getShrtCode() {
            return shrtCode;
        }
    }
}
