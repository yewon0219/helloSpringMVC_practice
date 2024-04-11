package kr.ac.hansung.cse.controller;

import kr.ac.hansung.cse.model.Offer;
import kr.ac.hansung.cse.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller //bean으로 등록.  spring container에 객체로 생성 됨.
public class OfferController {

    @Autowired
    private OfferService offerService;

    @GetMapping("/offers")
    public String showOffers(Model model) {
        List<Offer> offers = offerService.getAllOffers();
        model.addAttribute("id_offers", offers);

        return "offers";
    }

    @GetMapping("/createoffer")
    public String createOffer(Model model) {
        model.addAttribute("offer", new Offer()); //비어있는 새로운 객체 만들어 모델에 넣음.
        
        return "createoffer";
    }

    @PostMapping("/docreate") //주의!! PostMapping. createoffer.jsp에서 post method 사용함.
    public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
        //검증한 결과를 result에 넣음.

        if(result.hasErrors()) { //검증.
            System.out.println("== Form data dose not validated ==");

            List<ObjectError> errors = result.getAllErrors();

            for(ObjectError error:errors) {
                System.out.println(error.getDefaultMessage());
            }

            return "createoffer";
        }

        offerService.insert(offer);

        return "offercreated";
    }
    //model에 offer가 들어가있음. offer에는 data binding에 의해 테이블의 값이 다 들어가있음.
    //이를 offercreated 뷰로 넘겼기 때문에, 뷰는 model내의 offer에 접근 가능.!
    //때문에 offercreated.jsp에서 ${offer.name}으로 이름 받아올 수 있다.

}
