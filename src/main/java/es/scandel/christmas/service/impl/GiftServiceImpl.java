package es.scandel.christmas.service.impl;

import es.scandel.christmas.model.Gift;
import es.scandel.christmas.repository.GiftRepository;
import es.scandel.christmas.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GiftServiceImpl implements GiftService {

    @Autowired
    private GiftRepository giftRepository;

    @Override
    public Gift findById(String id){
        return giftRepository.findOne(id);
    }

    @Override
    public List<Gift> findAll(){
        return giftRepository.findAll();
    }

    @Override
    public Gift create(Gift gift){
        return giftRepository.save(gift);
    }

    @Override
    public Gift update(Gift gift){
        return giftRepository.save(gift);
    }

    @Override
    public void delete(String id){
        giftRepository.delete(id);
    }
}
