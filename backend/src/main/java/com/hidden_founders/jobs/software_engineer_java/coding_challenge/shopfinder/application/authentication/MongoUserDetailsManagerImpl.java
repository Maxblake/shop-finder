package com.hidden_founders.jobs.software_engineer_java.coding_challenge.shopfinder.application.authentication;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Component("userDetailsManager")
public class MongoUserDetailsManagerImpl extends UserDetailsManagerImpl {
    /**
     * Create a new user with the supplied details.
     *
     * @param user
     * @throws BadCredentialsException if there's already a user registered with the given email
     */
    @Override
    public void createUser(UserDetails user) throws BadCredentialsException {
        if (!usersDaoAdapter.save(user)) {
            throw new BadCredentialsException("There is already an account with that email address: " + user.getUsername());
        }
    }

    /**
     * Update the specified user.
     *
     * @param user
     */
    @Override
    public void updateUser(UserDetails user) {
        throw new NotImplementedException();
    }

    /**
     * Remove the user with the given login name from the system.
     *
     * @param username
     */
    @Override
    public void deleteUser(String username) {
        throw new NotImplementedException();
    }

    /**
     * Modify the current user's password. This should change the user's password in the
     * persistent user repository (datbase, LDAP etc).
     *
     * @param oldPassword current password (for re-authentication if required)
     * @param newPassword the password to change to
     */
    @Override
    public void changePassword(String oldPassword, String newPassword) {
        throw new NotImplementedException();
    }

    /**
     * Check if a user with the supplied login name exists in the system.
     *
     * @param username
     */
    @Override
    public boolean userExists(String username) {
        throw new NotImplementedException();
    }

    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = usersDaoAdapter.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("There is no account with that email address: " + username);
        }
        return user;
    }
}
