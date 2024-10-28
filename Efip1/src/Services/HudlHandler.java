package Services;

public class HudlHandler {
    public HudlHandler() {
    }

    public boolean upload() throws InterruptedException {
        System.out.println("Hudl upload in progress");
        Thread.sleep(4000);
        System.out.println("Hudl upload completed");
        //Change to return url
        return true;
    }
}
