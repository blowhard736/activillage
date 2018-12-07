package com.activillage.common.graph;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageMake {
	public static void make(String args) {
		BufferedImage img = new BufferedImage(270, 230, BufferedImage.TYPE_3BYTE_BGR);
		Graphics2D g = img.createGraphics();
		
		g.setColor(Color.black); // 색을 검정색으로 지정
		g.drawRect(0, 0, 270, 230); // 폭 270, 높이 230인 사각형을 그림
		
		g.setColor(Color.white); // 색을 흰색으로 지정
		g.fillRect(6, 6, 258, 218); // 상하좌우 간격 6, 폭 258, 높이 218 채움 
		g.setFont(new Font("굴림", Font.PLAIN, 12)); // 굴림 폰트 12
		g.setColor(Color.black); // 색을 검정색으로 지정

		// x=10, y=50 픽셀부터 문자열 그림
		g.drawString("The power of the Web is in its universality,", 10, 50);	
		g.drawString("Access by everyone regardless of disability", 10, 70);
		g.drawString("is an essential aspect.", 10, 90);
		g.drawString("[ 웹의 힘은 그것의 보편성에 있으며,", 10, 110); 
		g.drawString("장애에 구애 없이 모든 사람이 접근할 수 있는", 10, 130);
		g.drawString("것이 웹의 필수적인 요소이다. ]", 10, 150);
		
		g.setFont(new Font("굴림", Font.BOLD, 15)); // 굴림 폰트 볼드체 15
		g.setColor(Color.red); // 색을 빨간색으로 지정
		g.drawString("JSP로 이미지 생성.", 50, 190); // x=50, y=190 픽셀부터 문자열 그림
		
		// 그린 이미지를 ImageIO 객체를 통해 jpg 포맷으로 저장함.
		BufferedOutputStream os = null;
		try {
			os = new BufferedOutputStream(new FileOutputStream(args));
		} catch (FileNotFoundException e) {
			e.getMessage();
		}
		
		try {
			ImageIO.write(img, "jpg", os);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.getMessage();
		}
	}

}
