#!/usr/bin/env bash
#
#mv ./vivi.app.api/build/libs/vivi.app.api.war ./vivi.app.api/build/libs/root.war

rsync -avzP op.app.api/build/libs/ root@local.server:/data/op.app.server/app/
ssh root@local.server "docker restart hbappserver_java8_1"