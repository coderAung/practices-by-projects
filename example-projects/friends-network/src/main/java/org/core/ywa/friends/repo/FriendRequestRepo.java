package org.core.ywa.friends.repo;

import org.core.ywa.friends.entity.FriendRequest;
import org.core.ywa.friends.entity.pk.FriendRequestPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendRequestRepo extends JpaRepository<FriendRequest, FriendRequestPK> {
}
