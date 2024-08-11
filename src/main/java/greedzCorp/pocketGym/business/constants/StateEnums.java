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
}
