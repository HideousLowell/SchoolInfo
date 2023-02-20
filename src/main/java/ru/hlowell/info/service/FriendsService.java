package ru.hlowell.info.service;

import ru.hlowell.info.model.entity.Friends;
import ru.hlowell.info.repository.FriendsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendsService extends GenericService<Friends, Long> {

    private final FriendsRepository friendsRepository;

    @Autowired
    protected FriendsService(FriendsRepository friendsRepository) {
        super(friendsRepository);
        this.friendsRepository = friendsRepository;
    }

}
