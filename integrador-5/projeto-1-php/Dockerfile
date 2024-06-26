FROM composer:latest AS vendor

WORKDIR /app

COPY composer.json composer.json
COPY composer.lock composer.lock

RUN composer install \
    --no-interaction \
    --no-plugins \
    --no-scripts \
    --no-dev \
    --prefer-dist

COPY . .
RUN composer dump-autoload

FROM php:8.3-apache

ENV MYSQL_DB_HOST ${MYSQL_DB_HOST:-mysql}
ENV MYSQL_DB_NAME ${MYSQL_DB_NAME:-projeto_db}
ENV MYSQL_DB_USER ${MYSQL_DB_USER:-user_db}
ENV MYSQL_DB_PASSWORD ${MYSQL_DB_PASSWORD:-password}
ENV COMPOSER_ALLOW_SUPERUSER=1

RUN apt update && apt install -y \
    autoconf \
    zip \
    libzip-dev \
    gettext \
    git \
    libxml2-dev \
    libpq-dev \
    curl

RUN apt clean autoclean
RUN apt autoremove --yes
RUN rm -rf /var/lib/{apt,dpkg,cache,log}/

RUN docker-php-ext-install mysqli pdo pdo_mysql zip opcache pcntl soap bcmath
RUN pecl install xdebug && docker-php-ext-enable xdebug

COPY --from=vendor app/vendor/ ./vendor/
COPY . .
COPY docker-php-ext-xdebug.ini /usr/local/etc/php/conf.d/

ENV APACHE_RUN_USER www-data
ENV APACHE_RUN_GROUP www-data
ENV APACHE_LOG_DIR /var/log/apache2
ENV APACHE_LOCK_DIR /var/lock/apache2
ENV APACHE_PID_FILE /var/run/apache2.pid

RUN a2enmod rewrite
ADD apache-config.conf /etc/apache2/sites-enabled/000-default.conf
RUN service apache2 restart

RUN export XDEBUG_SESSION=1

