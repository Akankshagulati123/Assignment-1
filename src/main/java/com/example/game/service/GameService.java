package com.example.game.service;

import com.example.game.domain.Prize;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameService {
    private final Logger logger = LoggerFactory.getLogger(GameService.class);
    private List<Prize> prizes = new ArrayList<>();
    private Integer selectedPrizeId;
    private List<Prize> randomPrizes = new ArrayList<>();
    Prize prize = new Prize("$100");
    Prize prize1 = new Prize("Iphone");
    Prize prize2 = new Prize("Dell Laptop");
    Prize prize3 = new Prize("Empty");
    Prize prize4 = new Prize("Macbook Air M2");
    Prize prize5 = new Prize("Empty");
    Prize prize6 = new Prize("Redmi 12");
    Prize prize7 = new Prize("Ford Ranger");
    Prize prize8 = new Prize("Empty");
    Prize prize9 = new Prize("$300");
    Prize prize10 = new Prize("Empty");

    @PostConstruct
    void init() {
        prizes.add(prize);
        prizes.add(prize1);
        prizes.add(prize2);
        prizes.add(prize3);
        prizes.add(prize4);
        prizes.add(prize5);
        prizes.add(prize6);
        prizes.add(prize7);
        prizes.add(prize8);
        prizes.add(prize9);
        prizes.add(prize10);
        logger.debug("Loaded {} prizes", prizes.size());
    }

    public List<Prize> randomize() {
        logger.debug("About to get 3 random prizes from list");
        List<Prize> randomizedPrizes = new ArrayList<>();
        List<Prize> tempPrizeList = prizes;
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            Integer index = rand.nextInt(tempPrizeList.size());
            logger.debug("Extracted index : {}", index);
            Prize randomPrize = tempPrizeList.get(index);
            randomizedPrizes.add(randomPrize);
            tempPrizeList.remove(index);
        }

        randomPrizes = randomizedPrizes;

        return randomizedPrizes;
    }

    public List<Prize> getCurrentPrizes() {
        return randomPrizes;
    }

    public void setSelectedPrizeId(String prizeId) {
        selectedPrizeId = Integer.parseInt(prizeId);
    }
    public Integer getSelectedPrizeId() {
        return selectedPrizeId;
    }

    public Prize getSelectedPrize(){
        Integer selectedPrizeId =  getSelectedPrizeId();
        if(selectedPrizeId!=null) {
            return randomPrizes.get(selectedPrizeId);
        }else{
            return null;
        }
    }
}
