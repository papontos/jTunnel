# jTunnel
jTunnel is easy tunneling tools via ssh connection for those who need multiple hops of connection.

#Configuration
Configuration file is json look like this:
<br>
{<br>
  Configs:[<br>
    {<br>
      "sshUrl":"{tunnelUrl}",<br>
      "sshUser":"{tunnelUser}",<br>
      "sshPassword":"{tunnelPassword}",<br>
      "sshPort":"{tunnelport}",<br>
      "localPort":"{localport}",<br>
      "remoteUrl":"{remoteUrl}",<br>
      "remotePort":"{remotePort}"<br>
    }<br>
  ]<br>
}<br>
<br>
After change configuration. You will able to connect to your destination via localhost:{remotePort}.
<br>
<br>
jTunnel also able to have multiple tunnel connection by add a little bit config into json.
<br>
eg.<br>
{<br>
  Configs:[<br>
    {<br>
      "sshUrl":"{tunnelUrl1}",<br>
      "sshUser":"{tunnelUser1}",<br>
      "sshPassword":"{tunnelPassword1}",<br>
      "sshPort":"{tunnelport1}",<br>
      "localPort":"{localport1}",<br>
      "remoteUrl":"{remoteUrl1}",<br>
      "remotePort":"{remotePort1}"<br>
    },<br>
    {<br>
      "sshUrl":"{tunnelUrl2}",<br>
      "sshUser":"{tunnelUser2}",<br>
      "sshPassword":"{tunnelPassword2}",<br>
      "sshPort":"{tunnelport2}",<br>
      "localPort":"{localport2}",<br>
      "remoteUrl":"{remoteUrl2}",<br>
      "remotePort":"{remotePort2}"<br>
    }<br>
  ]<br>
}<br>





