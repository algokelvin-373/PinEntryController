package algokelvin.demo.pinentry;

public interface PinEntryService {
    void setTransformationMethod();
    void textPassword(int num);
    void removePassword();
    void btnBackEnable();
    void btnActionController();
    void btnActionEnable();
    void enableBtnNext(int background, int color);
}
