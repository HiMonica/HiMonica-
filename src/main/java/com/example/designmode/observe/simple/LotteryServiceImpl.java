package com.example.designmode.observe.simple;

public class LotteryServiceImpl implements LotteryService {

    private MinibusTargetService targetService = new MinibusTargetService();

    @Override
    public LotteryResult doDrew(String userId) {
        String lottery = targetService.lottery(userId);
        LotteryResult result = new LotteryResult();
        result.setData(lottery);
        return result;
    }
}
