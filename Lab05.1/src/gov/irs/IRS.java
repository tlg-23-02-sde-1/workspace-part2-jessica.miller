package gov.irs;

public interface IRS {
    public void register(TaxPayer payer); //What does the IRS do? (It collects taxes)
    public void collectTaxes();

    //Static factory method for the IRSEnum.Instance because IRSEnum is private
    //LAZY METHOD
    public static IRS getInstance() {
        return IRSEnum.INSTANCE;
    }
}
