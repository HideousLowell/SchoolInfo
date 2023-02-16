package ru.eshakin.schoolinfo.service;

import ru.eshakin.schoolinfo.repository.FriendsRepository;
import ru.eshakin.schoolinfo.model.entity.Friends;
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
