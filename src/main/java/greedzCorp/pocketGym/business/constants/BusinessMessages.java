package greedzCorp.pocketGym.business.constants;

public class BusinessMessages {

    public enum exerciseMessages{
        EXERCISE_CREATED("Antrenman/Egzersiz Eklendi."),
        EXERCISE_NOT_CREATED("Antrenman/Egzersiz Eklenemedi."),
        EXERCISE_UPDATED("Antrenman/Egzersiz Güncellendi."),
        EXERCISE_NOT_UPDATED("Antrenman/Egzersiz Güncellenemedi."),
        EXERCISE_DELETED("Antrenan/Egzersiz Silindi."),
        EXERCISE_NOT_DELETED("Antrenan/Egzersiz Silinemedi."),
        EXERCISE_IS_ALREADY_EXISTS("Antrenman Zaten Kayıtlı."),
        EXERCISE_NOT_FOUND("Antrenman Bulunamadı.")
        ;
        private String message;

        exerciseMessages(String message) {
            this.message = message;
        }
        public String getMessage(){
            return message;
        }
    }
    public enum trainerMessages{
        TRAINER_ADDED("Trainer Eklendi."),
        TRAINER_NOT_ADDED("Trainer Eklenemedi."),
        TRAINER_UPDATED("Trainer Güncellendi."),
        TRAINER_NOT_UPDATED("Trainer Güncellenemedi."),
        TRAINER_DELETED("Trainer Silindi."),
        TRAINER_NOT_DELETED("Trainer Silinemedi."),
        TRAINER_IS_ALREADY_EXISTS("Trainer Zaten Kayıtlı."),
        TRAINER_NOT_FOUND("Trainer Bulunamadı.")
        ;
        private String message;
        trainerMessages(String message) {
            this.message = message;
        }
        public String getMessage(){
            return message;
        }
    }
    public enum productPriceMessages{
        PRODUCT_PRICE_NOT_FOUND("Ücret Bilgisi Bulunamadı."),
        PRODUCT_PRICE_ADDED("Ücret Bilgisi Kaydedildi."),
        PRODUCT_PRICE_NOT_ADDED("Ücret Bilgisi Kaydedilemedi."),
        PRODUCT_PRICE_UPDATED("Ücret Bilgisi Güncellendi."),
        PRODUCT_PRICE_NOT_UPDATED("Ücret Bilgisi Güncellenemedi."),
        PRODUCT_PRICE_DELETED("Ücret Bilgisi Silindi."),
        PRODUCT_PRICE_NOT_DELETED("Ücret Bilgisi Silinemedi.");

        private String message;
        productPriceMessages(String message) {
            this.message = message;
        }
        public String getMessage() {
            return message;
        }
    }

    public enum productMessages{
        PRODUCT_NOT_FOUND("Ürün Bulunamadı."),
        PRODUCT_ADDED("Ürün Kaydedildi."),
        PRODUCT_NOT_ADDED("Ürün Kaytdedilemedi."),
        PRODDUCT_CREATED("Ürün Oluşturuldu.");

        private String message;

        productMessages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public enum productOrderMessages{
        PRODUCT_ORDER_CREATED("Ürün Siparişiniz Başarıyla Oluşturuldu."),
        PRODUCT_ORDER_NOT_CREATED("Ürün Siparişiniz Oluşturulamadı.");


        private String message;

        productOrderMessages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public enum partyMessages{
        PARTY_USER_CREATED("Üye Başarıyla Kaydedildi."),
        PARTY_USER_NOT_CREATED("Üye Kaydı Başarısız."),
        PARTY_USER_IS_ALREADY_EXISTS("Üye Zaten Kayıtlı.");


        private String message;

        partyMessages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
