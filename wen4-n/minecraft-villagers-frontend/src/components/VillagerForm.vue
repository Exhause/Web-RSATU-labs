<template>
  <b-form @submit.prevent="onClickSave">
    <b-form-group label="Имя">
      <b-form-input v-model="villager.name" required />
    </b-form-group>
    <b-form-group label="Уровень торговли">
      <b-form-input
        v-model.number="villager.tradeLevel"
        type="number"
        min="1"
        max="5"
        required
      />
    </b-form-group>
    <b-form-group label="Профессия">
      <b-form-input v-model="villager.profession" required />
    </b-form-group>
    <div class="d-flex justify-content-end gap-2 mt-1">
      <b-button variant="secondary" @click="onClickCancel"> Отмена </b-button>
      <b-button variant="primary" type="submit" :disabled="saving">
        Сохранить
      </b-button>
    </div>
  </b-form>
</template>

<script>
export default {
  props: {
    initialVillager: {
      type: Object,
      required: true,
    },
    onCancel: {
      type: Function,
      required: true,
    },
    onSave: {
      type: Function,
      required: true,
    },
  },

  data() {
    return {
      villager: { ...this.initialVillager },
      saving: false,
    };
  },

  methods: {
    onClickCancel() {
      this.onCancel();
    },

    onClickSave() {
      this.saving = true;
      this.onSave(this.villager);
    },
  },
};
</script>
