package gg;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;


public class steganography_least_significant_bit_sample {
static int newx;
static int newy;
static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String libPath = System.getProperty("java.library.path");
//		System.load("E:/new java/cv/opencv/build/java/x64/opencv_java330.dll"); 
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//		System.loadLibrary("opencv_java330"); 
		//System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
//		final  Mat image = Imgcodecs.imread("G:/xampp3/htdocs/encrypt/sampel2.jpg",Imgcodecs.IMREAD_UNCHANGED);
//		Imgcodecs.imwrite("G:/xampp3/htdocs/encrypt/image1original.jpg", image);
		final  Mat image = Imgcodecs.imread("sampel3.jpg",Imgcodecs.IMREAD_UNCHANGED);
//		Imgcodecs.imwrite("image1original.jpg", image);
		N = image.width();
		Mat iterasi1 = encrypt(image);//		
//		Mat iterasi2 = encrypt(iterasi1);
//		Mat iterasi3 = encrypt(iterasi2);
//		Mat iterasi4 = encrypt(iterasi3);
//		Mat iterasi5 = encrypt(iterasi4);
//		Imgcodecs.imwrite("image3antiarnold.png", iterasi1);
//		final  Mat imagen = Imgcodecs.imread("image2arnold.jpg",Imgcodecs.IMREAD_UNCHANGED);
//		decrypt(imagen);
	}
	public static Mat  encrypt(Mat image){
		Mat image2 = new Mat(N,N,image.type());
		for (int x=0; x< N; x++){
			for(int y = 0; y< N ; y++){
				int oldx = x;
				int oldy= y;
				newx = ((oldx+oldy)%(N)); 
				newy = ((oldx+(2*oldy))%(N));
				System.out.println(x+","+y+"=>" +newx+","+newy);
				image2.put(newx, newy,image.get(x, y));
			}
		}
		Imgcodecs.imwrite("outAsli.png", image2);
		return image2;
	}
	

}
