package com.example.Splitwise12.controller;

import com.example.Splitwise12.dto.SettleUpGroupRequestDto;
import com.example.Splitwise12.dto.SettleUserRequestDto;
import com.example.Splitwise12.modles.Transaction;
import com.example.Splitwise12.services.SettleUpService;

import java.util.List;

public class SettleUpController {
    private final SettleUpService settleUpService;

    public SettleUpController(SettleUpService settleUpService) {
        this.settleUpService = settleUpService;
    }

    // /settle/user/{{user_id}}
    public List<Transaction> settlerUser(SettleUserRequestDto dto){
        return settleUpService.settleUser(dto.getUserId());
    }

    // /settle/user/{{group_id}}
    public List<Transaction> settlerGroup(SettleUpGroupRequestDto dto){
        return settleUpService.settleGroup(dto.getGroupId());
    }
}