<template>
  <div class="reg_page">
    <div class="q-pa-sm q-pa-md form_div">
      <h4>Регистрация</h4>
      <q-form @submit.prevent="onSubmit" class="q-gutter-sm q-gutter-md">
        <q-input
          clearable
          filled
          square
          v-model="name"
          label="Имя*"
          hint="Введите имя или никнейм"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'Пожалуйста, заполните поле',
          ]"
        />
        <q-input
          clearable
          filled
          square
          type="email"
          v-model="email"
          label="Email*"
          hint="Введите email"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'Пожалуйста, заполните поле',
          ]"
        />
        <q-select
          square
          filled
          v-model="role"
          :options="options"
          label="Выберите тип аккаунта"
          :option-value="
            (opt) => (Object(opt) === opt && 'id' in opt ? opt.id : null)
          "
          :option-label="
            (opt) =>
              Object(opt) === opt && 'name' in opt ? opt.name : '- Null -'
          "
        />
        <span class="about_acc" @click="about">Подробнее про аккаунты</span>
        <q-input
          v-model="password"
          square
          filled
          label="Пароль*"
          :type="isPwd ? 'password' : 'text'"
          hint="Введите пароль"
          lazy-rules
          :rules="[
            (val) =>
              (val && val.length > 0) ||
              'Пожалуйста, заполните поле. Пароль должен содержать больше 6 символов',
          ]"
        >
          <template v-slot:append>
            <q-icon
              :name="isPwd ? 'visibility_off' : 'visibility'"
              class="cursor-pointer"
              @click="isPwd = !isPwd"
            />
          </template>
        </q-input>
        <div>
          <q-btn
            size="15px"
            :loading="loading"
            color="primary"
            @click="simulateProgress()"
            style="width: 100%"
          >
            Зарегистрироваться
            <template v-slot:loading>
              <q-spinner-hourglass class="on-left" />
              Loading...
            </template>
          </q-btn>
          <q-btn
            size="15px"
            color="red-5"
            icon-right="check_circle_outline"
            label="Я зарегистрирован(а)"
            style="width: 100%; margin-top: 5px"
            @click.native="$router.push('/auth/login')"
          />
        </div>
      </q-form>
    </div>
  </div>
</template>

<script>
export default {
  name: "Register",
  data() {
    return {
      options: [{ name: "Владелец" }, { name: "Посетитель" }],
      loading: false,
      name: null,
      email: null,
      role: null,
      password: null,
      isPwd: false,
    };
  },

  methods: {
    onSubmit() {},
    about() {
      this.$q.dialog({
        title: "Про аккаунты",
        message: `Здравствуйте! <p style="text-align: justify;">Наше приложение используют две категории пользователей: 
          владельцы и посетители. Создав аккаунт <b>владельца</b> вы сможете создать страницу вашего заведения и размещать информацию 
          о проводимых вами акциях и использовать другие специальные функции которые будут разработаны в будущем. Создав аккаунт <b>посетителя</b>
        вы сможете создать страницу места, которое вы посетили и хотели бы посоветовать другим людям. После создания данной страницы вы больше не сможете управлять ей.</p>`,
        html: true,
      });
    },
    simulateProgress() {
      // we set loading state
      this.loading = true;
      // simulate a delay
      setTimeout(() => {
        // we're done, we reset loading state
        this.loading = false;
      }, 3000);
    },
  },
};
</script>

<style scoped>
.reg_page {
  width: 100%;
}
.form_div {
  border-radius: 5px;
  margin: auto;
  background-color: rgba(255, 255, 255, 0.8);
  width: 20%;
}
.form_div h4 {
  margin: 0;
  margin-bottom: 30px;
  text-align: center;
}
.about_acc {
  cursor: pointer;
  color: #128dee;
  text-decoration-line: underline;
  text-align: center;
}

@media (max-width: 1025px) {
  .form_div {
    width: 50%;
  }
}
@media (max-width: 550px) {
  .form_div {
    margin: auto;
    width: 95%;
  }
}
</style>