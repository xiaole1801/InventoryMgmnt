package init;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import ui.LoginForm;
import user.UserClient;

public class main {
	public static UserClient client;
	private static Point pp;

	public static void main(String[] args) {
		// validate the user identification
		LoginForm lf = new LoginForm(new javax.swing.JFrame(), true);
		double winWidth = Toolkit.getDefaultToolkit().getScreenSize()
				.getWidth();
		double winHeight = Toolkit.getDefaultToolkit().getScreenSize()
				.getHeight();
		Dimension pd = new Dimension(lf.getSize());
		pp = new Point((int) (winWidth / 2 - pd.getWidth() / 2),
				(int) (winHeight / 2 - pd.getHeight() / 2));
		lf.setLocation(pp);
		lf.setVisible(true);
	}

}
