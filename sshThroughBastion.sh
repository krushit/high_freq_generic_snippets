ssh -i $KEY_PAIR -o "proxycommand ssh -W %h:%p -i $KEY_PAIR ec2-user@$BASTION_HOST" -o UserKnownHostsFile=/dev/null -o StrictHostKeyChecking=no ec2-user@$1
