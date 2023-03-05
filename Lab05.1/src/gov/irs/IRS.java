package gov.irs;


//ESSENTIALLY A SCREEN INFRONT OF ENUM TO DISGUISE THE ENUM TYPE
public interface IRS {
    void register(TaxPayer payer); //What does the IRS do? (It collects taxes)
    void collectTaxes();

    //Static factory method for the IRSEnum.Instance because IRSEnum is private
    //LAZY METHOD
    public static IRS getInstance() {
        return IRSEnum.INSTANCE;
    }
}
