# jTunnel
jTunnel is easy tunneling tools via ssh connection for those who need multiple hops of connection.

#Configuration
Configuration file is json look like this:

{
  Configs:[
    {
      "sshUrl":"{tunnelUrl}",
      "sshUser":"{tunnelUser}",
      "sshPassword":"{tunnelPassword}",
      "sshPort":"{tunnelport}",
      "localPort":"{localport}",
      "remoteUrl":"{remoteUrl}",
      "remotePort":"{remotePort}"
    }
  ]
}

After change configuration. You will able to connect to your destination via localhost:{remotePort}.


jTunnel also able to have multiple tunnel connection by add a little bit config into json.

eg.
{
  Configs:[
    {
      "sshUrl":"{tunnelUrl1}",
      "sshUser":"{tunnelUser1}",
      "sshPassword":"{tunnelPassword1}",
      "sshPort":"{tunnelport1}",
      "localPort":"{localport1}",
      "remoteUrl":"{remoteUrl1}",
      "remotePort":"{remotePort1}"
    },
    {
      "sshUrl":"{tunnelUrl2}",
      "sshUser":"{tunnelUser2}",
      "sshPassword":"{tunnelPassword2}",
      "sshPort":"{tunnelport2}",
      "localPort":"{localport2}",
      "remoteUrl":"{remoteUrl2}",
      "remotePort":"{remotePort2}"
    }
  ]
}





