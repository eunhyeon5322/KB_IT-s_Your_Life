package org.scoula.travel.dataimport;

import org.scoula.travel.dao.TravelDao;
import org.scoula.travel.dao.TravelDaoImpl;
import org.scoula.travel.domain.TravelImageVO;
import org.scoula.database.JDBCUtil;

import java.io.File;

public class ImportImageData {
    public static void main(String[] args) {
        TravelDao dao = new TravelDaoImpl();

        File dir = new File("../travel image");
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                String filename = file.getName();
                long travelNo = Long.parseLong(filename.split("--")[0]); // 관광지 no 얻기

                TravelImageVO image = TravelImageVO.builder()
                        .filename(filename)
                        .travelNo(travelNo)
                        .build();

                dao.insertImage(image);
                System.out.println("Inserted image: " + filename);
            }
        } else {
            System.out.println("디렉토리 또는 파일이 존재하지 않습니다.");
        }

        JDBCUtil.close();
    }
}
