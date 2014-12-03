package load_and_save_classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Set;

import math_classes.Face;
import math_classes.Model;
import math_classes.Point;
import math_classes.Segment;

public class Loader {

	File file;
	
	public Loader(File file) {
		this.file = file;
	}
	
	public Model load() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String modelProperties[] = br.readLine().split(" ");
			//CREATION DES LISTES DE POINT, SEGMENTS ET FACES.
			Point[] points = new Point[Integer.parseInt(modelProperties[0])];
			Segment[] segments = new Segment[Integer.parseInt(modelProperties[1])];
			Set<Face> faces = new HashSet<Face>(Integer.parseInt(modelProperties[2]));
			//ON ENREGISTRE LES POINTS
			for (int i=0 ; i<Integer.parseInt(modelProperties[0]);i++) {
				String[] coordPoint = br.readLine().split(" ");
				points[i] = new Point(Double.parseDouble(coordPoint[0]), Double.parseDouble(coordPoint[1]), Double.parseDouble(coordPoint[2]));
			}
			//ON ENREGISTRE LES SEGMENTS
			for (int i=0 ; i<Integer.parseInt(modelProperties[1]);i++) {
				String[] coordSegment = br.readLine().split(" ");
				segments[i] = new Segment(points[Integer.parseInt(coordSegment[0])-1], points[Integer.parseInt(coordSegment[1])-1]);
			}
			//ET ENFIN LES FACES
			for (int i=0 ; i<Integer.parseInt(modelProperties[2]);i++) {
				String[] coordFace = br.readLine().split(" ");
				faces.add(new Face(segments[Integer.parseInt(coordFace[0])-1], segments[Integer.parseInt(coordFace[1])-1], segments[Integer.parseInt(coordFace[2])-1]));
			}
			br.close();
			return new Model(faces);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
