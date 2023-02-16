package ru.eshakin.schoolinfo.model;

/**
 *  Enum не именуется в верхнем регистре
 *  для легкой конвертации в Postgres enum
 */
public enum Status {
    Start,
    Success,
    Failure
}
