package greedzCorp.pocketGym.api.controllers;

import greedzCorp.pocketGym.business.abstracts.CRUD.PartyService;
import greedzCorp.pocketGym.business.requests.PartyRequest;
import greedzCorp.pocketGym.core.utilities.results.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/party")
public class PartyController {
    private PartyService partyService;

    public PartyController(PartyService partyService) {
        this.partyService = partyService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody PartyRequest partyRequest) {
        return this.partyService.add(partyRequest);
    }
}
