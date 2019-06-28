final static String RECURSO1="Recurso 1";final static String RECURSO2="Recurso 2";
public static void main(String[]args){try
    {Thread t1=new Thread1();
    Thread t2=new Thread2();
t1.start();
//t1.join();
t2.start();
//t2.join();
}catch(Throwable e){e.printStackTrace();}JOptionPane.showMessageDialog(null,"Programa entrou em DEADLOCK");Thread t3=new Thread3();t3.start();}
private static class Thread1 extends Thread {
    @Override
    public void run() {
        synchronized (RECURSO1) {
            try {
                System.out.println("Thread #1: Bloqueou o recurso 1");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}System.out.println("Thread #1: Tentando acesso ao recurso 2");
// Aguarda ate obter o recurso 2.
synchronized(RECURSO2){System.out.println("Thread #1: Bloqueou o recurso 2");}

private static class Thread2 extends Thread {
}

    @Override
    public void run() {
        synchronized (RECURSO2) {
            try {
                System.out.println("Thread #2: Bloqueou o recurso 2");
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Theread #2: Tentando o acesso ao recurso 1");
            synchronized (RECURSO1) {
                System.out.println("Thread #2: Bloqueou o recurso 1");
            }
        }
    }

private static class Thread3 extends Thread {
public void run() {
System.out.println("Iniciou Thread 3");
System.out.println("Thread #3: Entrando em ação");
JOptionPane.showMessageDialog(null, "Thread #3 no comando");
JOptionPane.showMessageDialog(null, "Algoritmo do Avestruz implementado com sucesso");
System.out.println("Finalizou a Thread 3");
System.exit(0);
}
}