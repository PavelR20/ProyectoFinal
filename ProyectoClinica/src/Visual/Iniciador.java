package Visual;

public class Iniciador {

	public static void main(String[] args) {
		
		CargarLogin cargar = new CargarLogin();
		Login login = new Login();
		
		cargar.setLocationRelativeTo(null);
		cargar.setResizable(false);
		cargar.setUndecorated(true);
		cargar.setVisible(true);
		
		for (int i = 1; i <= 100; i++) {
			try {
				Thread.sleep(80);
				cargar.Barra.setValue(i);
				
				if(i%2 == 0) {
					cargar.lblEsperar.setText("Porfavor Esperar..");
				}else {
					cargar.lblEsperar.setText("Porfavor Esperar...");
				}
				
				if(i == 100) {
					cargar.dispose();
					login.setVisible(true);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
