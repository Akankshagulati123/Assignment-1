package com.example.game.controller;

import com.example.game.service.GameService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class GameController {
    private final Logger logger = LoggerFactory.getLogger(GameController.class);
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String getPrizeList(HttpServletRequest request){
        request.setAttribute("prizes", gameService.randomize());

        return "play";
    }

    @PostMapping("/submit")
    public String submitChoice(HttpServletRequest request){
        String prizeId = request.getParameter("prizeId");

        gameService.setSelectedPrizeId(prizeId);

        return "redirect:/";
    }

    @GetMapping("/results")
    public String get(HttpServletRequest request){
        request.setAttribute("prizes", gameService.getCurrentPrizes());
        request.setAttribute("selectedPrize", gameService.getSelectedPrize());

        return "results";
    }
}
