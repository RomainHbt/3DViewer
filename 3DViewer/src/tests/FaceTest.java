package tests;
import static org.junit.Assert.*;
import maths_classes.Face;
import maths_classes.Point;
import maths_classes.Segment;

import org.junit.Test;

public class FaceTest {

	@Test
	public void testBarycentre() {
		Point res = new Point(2.0, 2.0, 2.0);
		
		Point p1 = new Point(1, 1, 1, 1);
		Point p2 = new Point(2, 2, 2, 2);
		Point p3 = new Point(3, 3, 3, 3);
		
		Segment s1 = new Segment(p1, p2, 1);
		Segment s2 = new Segment(p1, p3, 2);
		Segment s3 = new Segment(p2, p3, 3);
		
		Face f = new Face(s1, s2, s3, 1);
		
		assertEquals(f.getBarycentre().toString(), res.toString());
	}

}
