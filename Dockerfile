FROM adoptopenjdk/openjdk11:ubi AS build
WORKDIR /workspace/assignment-helmes-backend
COPY . /workspace/assignment-helmes-backend
RUN build=/root/.gradle ./gradlew clean build
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*.jar)

FROM adoptopenjdk/openjdk11:ubi
VOLUME /tmp
ARG DEPENDENCY=/workspace/assignment-helmes-backend/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /assignment-helmes-backend/lib
COPY --from=build ${DEPENDENCY}/META-INF /assignment-helmes-backend/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /assignment-helmes-backend
ENTRYPOINT ["java","-cp","assignment-helmes-backend:assignment-helmes-backend/lib/*","ee.helmes.assignment.Application"]

EXPOSE 8090