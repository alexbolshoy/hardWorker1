public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }
    @FunctionalInterface
    public interface OnTaskErrorListener{
        void onError(String result);
    }
    //Для этого создайте новый функциональный интерфейс OnTaskErrorListener, определите там метод onError()
//Добавьте в класс Worker переменную errorCallback типа OnTaskErrorListener
    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void start() {

        for (int i = 0; i < 100; i++) {
            if(i==33){
                errorCallback.onError("Task " + 33 + " not done");
            }else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }

}
