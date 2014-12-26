package model_classes;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import math_classes.Segment;


public class Loader {
	
	private String file;
	private int npoints, nsegments, nfaces;
	private double minX, minY, maxX, maxY;
	
		
	public Loader(String file) {
		super();
		this.file = file;
	}
	
	public Model load() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String[] modelProperties = br.readLine().split(" ");
			String[] pointProperties, segmentProperties, faceProperties;
			npoints = Integer.parseInt(modelProperties[0]);
			nsegments = Integer.parseInt(modelProperties[1]);
			nfaces = Integer.parseInt(modelProperties[2]);
			Map<Integer, Point> points = new HashMap<Integer, Point>();
			Map<Integer, Segment> segments = new HashMap<Integer, Segment>();
			List<Face> faces = new LinkedList<Face>();
			for (int i = 0 ; i<npoints ; i++) {
				pointProperties = br.readLine().split(" ");
				if (Double.parseDouble(pointProperties[0])>maxX)
					maxX = Double.parseDouble(pointProperties[0]);
				else if (Double.parseDouble(pointProperties[0])<minX)
					minX = Double.parseDouble(pointProperties[0]);
				if (Double.parseDouble(pointProperties[1])>maxY)
					maxY = Double.parseDouble(pointProperties[1]);
				else if (Double.parseDouble(pointProperties[1])<minY)
					minY = Double.parseDouble(pointProperties[1]);
				points.put(i+1, new Point(Double.parseDouble(pointProperties[0]), Double.parseDouble(pointProperties[1]), Double.parseDouble(pointProperties[2])));
			}
			for (int i = 0 ; i<nsegments ; i++) {
				segmentProperties = br.readLine().split(" ");
				segments.put(i+1 ,new Segment(points.get(Integer.parseInt(segmentProperties[0])), points.get(Integer.parseInt(segmentProperties[1]))));
			}
			for (int i = 0 ; i<nfaces ; i++) {
				faceProperties = br.readLine().split(" ");
				faces.add(new Face(segments.get(Integer.parseInt(faceProperties[0])), segments.get(Integer.parseInt(faceProperties[1])), segments.get(Integer.parseInt(faceProperties[2]))));
			}
			Constants.zoomFactor = Math.abs((int)(maxY+minY))/10;
			Model m = new Model(faces, maxX, minX, maxY, minY, npoints, nsegments, nfaces, file.split("/")[file.split("/").length-1]);
			br.close();
			return m;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getFile() {
		String[] files = file.split("/");
		return files[files.length-1];
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getNpoints() {
		return npoints;
	}

	public void setNpoints(int npoints) {
		this.npoints = npoints;
	}

	public int getNsegments() {
		return nsegments;
	}

	public void setNsegments(int nsegments) {
		this.nsegments = nsegments;
	}

	public int getNfaces() {
		return nfaces;
	}

	public void setNfaces(int nfaces) {
		this.nfaces = nfaces;
	}
}
