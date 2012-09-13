package nl.tweeenveertig.openstack.client.impl;

import nl.tweeenveertig.openstack.client.Account;
import nl.tweeenveertig.openstack.client.Client;
import nl.tweeenveertig.openstack.command.core.AbstractCommand;
import nl.tweeenveertig.openstack.command.identity.AuthenticationCommand;
import nl.tweeenveertig.openstack.command.identity.access.Access;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public class ClientImpl implements Client {

    private HttpClient httpClient = new DefaultHttpClient();

    public Account authenticate(String tenant, String username, String password, String authUrl) {
        AuthenticationCommand command = new AuthenticationCommand(httpClient, authUrl, tenant, username, password);
        Access access = command.call();
        return new AccountImpl(command, httpClient, access);
    }

}
