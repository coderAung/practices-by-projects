package org.core.ywa.friends.repo;

import java.util.Optional;

import org.core.ywa.friends.entity.Friend;
import org.core.ywa.friends.entity.pk.FriendPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRepo extends JpaRepository<Friend, FriendPK> {

	Optional<Friend> findByOwnerIdAndFriendId(int ownerId, int friendId);

}
