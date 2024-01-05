package io.getarrays.securecapita.Stores.stores;
import java.util.List;

import io.getarrays.securecapita.dto.StoresVO;
import io.getarrays.securecapita.service.StoresService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/stores")
public class StoresController {

    private final StoresService StoresService;
    private List<String> processes;

    public StoresController(StoresService storesRequestService) {
        this.purchaseRequestService = purchaseRequestService;

    }

    @PostMapping("/requestprocess")
    public String getStoresProcess(@RequestBody StoresVO requestVO) {
        String processLabel = null;
        processLabel = this.StoresService.getStoresProcessByName(requestVO.getProcessName());
        return processLabel;
    }

    @GetMapping("/allprocess")
    public List<String> getAllStores() {
        return this.processes;
    }

    @PostConstruct
    public List<String> initializeProcesses() {
        processes = List.of("INITIATION BY ADMINISTRATION OFFICER",

                "APPROVAL BY PRINICIPAL ADMINISTRATION",

                "AUTHORAZATION BY HEAD OF ADMINISTRATION",

                "SUBMISSION TO BOARD OF SURVEY BY HEAD OF ADMISTRATION",

                "COMPLETION"
        );
        return processes;
    }

}
