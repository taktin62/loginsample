package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        // セキュリティ設定を無視するリクエスト設定
        // 静的リソースに対するアクセスはセキュリティ設定を無視する
        web.ignoring().antMatchers("/css/**", "/img/**", "/js/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()  //HttpSecurityから、アクセス範囲を決めるクラスを取得
                // アクセス権限の設定
                // アクセス制限の無いURL
                .antMatchers("/", "/login", "/error","/signup","/signupConfirmation","/signupDone","/loginSuccess","/menuDetails","/menuEdit","/menuConfigramation","/menuDone").permitAll()
                //↑ルート「/」は全ユーザーがアクセス可能
                // その他は認証済みであること
                .anyRequest().authenticated()  //他のURLは認証が必要
                .and()
          //.httpBasic(); ①BASIC認証を使用する ➁BASIC認証をやめてForm認証を行う
            .formLogin()  //認証ページは/login_page
                // ログイン画面
                .loginPage("/login")
                // 認証処理
                .loginProcessingUrl("/authenticate")
                // ログイン成功
                .defaultSuccessUrl("/loginSuccess")
                // ログイン失敗
                .failureUrl("/login")
                // usernameのパラメータ名
                .usernameParameter("username")  //ユーザー名とパスワードの項目はusenameとpassword
                // passwordのパラメータ名
                .passwordParameter("password")
                .and()
              //.permintAll(); 全ユーザーのアクセスを許可する
            .logout()
                // ログアウト処理
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                // ログアウト成功時の遷移先
                .logoutSuccessUrl("/login")
                // ログアウト時に削除するクッキー名
                .deleteCookies("JSESSIONID")
                // ログアウト時のセッション破棄を有効化
                .invalidateHttpSession(true)
                .permitAll()
                .and()
            .sessionManagement()
                // セッションが無効な時の遷移先
                .invalidSessionUrl("/invalidSession");
    }

    @Autowired
    protected void config(AuthenticationManagerBuilder auth) throws Exception {
    	//HttpSecurityを引数に受けるconfigureメソッドの他にAuthenticationManagerBuilderを受け取るメソッドがあり、ユーザー認証処理はここに設定を記述する。
        auth
            .inMemoryAuthentication()  //インメモリ認証を行なう指定
                .withUser(
                        User.withDefaultPasswordEncoder()
                        .username("foo").password("foopass").roles("USER").build())
                        .and()
            .inMemoryAuthentication()
                .withUser(
                        User.withDefaultPasswordEncoder()
                        .username("bar").password("barpass").roles("ADMIN", "USER").build());
    }

}