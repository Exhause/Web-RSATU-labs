<template>
  <b-form @submit.prevent="onClickSave">
    <b-form-group label="Название">
      <b-form-input v-model="item.name" required />
    </b-form-group>
    <b-form-group label="Количество">
      <b-form-input
        v-model.number="item.quantity"
        type="number"
        min="1"
        required
      />
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
    initialItem: {
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
      item: { ...this.initialItem },
      saving: false,
    };
  },

  methods: {
    onClickCancel() {
      this.onCancel();
    },

    onClickSave() {
      this.saving = true;
      this.onSave(this.item);
    },
  },
};
</script>
