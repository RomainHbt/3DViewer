package bibliotheque;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import exceptions.IncorrectFileException;

public class BibliothequeController {

	@SuppressWarnings("resource")
	public static boolean pathVerification(String path) throws Exception {
		// Ouverture du fichier
		InputStream ips = new FileInputStream(path);
		InputStreamReader ipsr = new InputStreamReader(ips);
		BufferedReader br = new BufferedReader(ipsr);

		// Calcul du nombre de points, segments et faces
		String ligne = br.readLine();
		String[] quantites = ligne.split(" ");
		int nbPoints = Integer.parseInt(quantites[0]);
		int nbSegments = Integer.parseInt(quantites[1]);
		int nbFaces = Integer.parseInt(quantites[2]);

		// Verification des coordonnees des points
		for (int i = 0; i < nbPoints; i++) {
			ligne = br.readLine();
			if (ligne.split(" ").length != 3) {
				throw new IncorrectFileException(
						"Nombre de coordonnees de points incorrect");
			}
		}

		// Verification des coordonnees des segments
		for (int i = 0; i < nbSegments; i++) {
			ligne = br.readLine();
			if (ligne.split(" ").length != 2) {
				throw new IncorrectFileException(
						"Nombre de coordonnees de segements incorrect");
			}
		}

		// Verification des coordonnees des faces
		for (int i = 0; i < nbFaces; i++) {
			ligne = br.readLine();
			if (ligne.split(" ").length != 3) {
				throw new IncorrectFileException(
						"Nombre de coordonnees de faces incorrect");
			}
		}

		br.close();
		return true;
	}

	public static boolean addModele(String name, String path,
			String description, String keywords) {
		try {
			if (name.equals("") || name == null)
				return false;
			if (path.equals("") || path == null)
				return false;
			if (description.equals("") || description == null)
				return false;
			if (keywords.equals("") || keywords == null)
				return false;

			return Bibliotheque.addModel(name, path, description, keywords);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
