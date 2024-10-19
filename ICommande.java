package lab;

interface ICommand {
    void Execute();
    void Undo();
}
class LampaOn implements  ICommand{
    Lampa _lampa;

    public LampaOn(Lampa lampa) {
        this._lampa = lampa;
    }

    public void Undo() {
        _lampa.On();
    }

    public void Execute() {
        _lampa.Off();
    }
}
class LampaOff implements ICommand{
    Lampa _lampa;

    public LampaOff(Lampa lampa) {
        this._lampa = lampa;
    }

    public void Undo() {
        _lampa.Off();
    }

    public void Execute() {
       _lampa.On();
    }
}
class Lampa{
    void On(){
        System.out.println("lab.Lampa onnnn");
    }
    void Off(){
        System.out.println("lab.Lampa offf");
    }
}
class TVon implements  ICommand{
    TV _tv;

    public TVon(TV tv) {
        this._tv = tv;
    }

    public void Undo() {
        _tv.On();
    }

    public void Execute() {
        _tv.Off();
    }
}
class TVoff implements ICommand{
    TV _tv;

    public TVoff(TV tv) {
        this._tv = tv;
    }

    public void Undo() {
        _tv.Off();
    }

    public void Execute() {
        _tv.On();
    }
}
class TV{

    void On(){
        System.out.println("Tv onnnn");
    }
    void Off(){
        System.out.println("Tv offf");
    }
}
class RemoteControl{
    private ICommand _oncommand;
    private ICommand _offcommand;
    void SetCommands(ICommand oncommand, ICommand offcommand){
        _oncommand = oncommand;
        _offcommand = offcommand;
    }
    void PressOnButton(){
        _oncommand.Execute();
    }
    void PressOffButton(){
        _offcommand.Execute();
    }
    void PressUndoButton(){
        _oncommand.Undo();
    }
}
class Main{
    public static void main(String[] args) {
        Lampa lampa = new Lampa();
        TV tv = new TV();
        ICommand lon = new LampaOn(lampa);
        ICommand loff = new LampaOff(lampa);

        ICommand ton = new TVon(tv);
        ICommand toff = new TVoff(tv);

        RemoteControl remoteControl = new RemoteControl();

        remoteControl.SetCommands(lon, loff);
        System.out.println("lampa remote");
        remoteControl.PressOnButton();
        remoteControl.PressOffButton();
        remoteControl.PressUndoButton();

        remoteControl.SetCommands(ton, toff);
        System.out.println("tv remote");
        remoteControl.PressOnButton();
        remoteControl.PressOffButton();
        remoteControl.PressUndoButton();
    }
}